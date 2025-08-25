import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable()
export class ErrorHandlingInterceptor implements HttpInterceptor {
  constructor(private router: Router) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    return next.handle(request).pipe(
      catchError((error: any) => {
        if (error instanceof HttpErrorResponse) {
          console.error(`HTTP Error: ${error.status} ${error.statusText}`, error);

          switch (error.status) {
            case 400:
              console.log('Bad Request. Please check the data sent');
              break;

            case 401:
              console.log('Unauthorized. Redirecting to login.');
              this.router.navigate(['/login']);
              break;

            case 404:
              console.log('Resource not found.');
              this.router.navigate(['/not-found']);
              break;

            case 405:
              console.log('Method not allowed for this endpoint.');
              break;

            case 500:
              console.log('Server Error. Please try again later.');
              break;

            default:
              console.log(`An unexpected HTTP error occurred: ${error.status}`);
              break;
          }
        } else {
          console.error('An non-HTTP error occurred', error);
        }
        return throwError(() => error);
      })
    );
  }
}
