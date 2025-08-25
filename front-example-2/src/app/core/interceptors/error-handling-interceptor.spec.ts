import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HTTP_INTERCEPTORS, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { ErrorHandlingInterceptor } from './error-handling-interceptor';


describe('ErrorHandlingInterceptor', () => {
  let routerSpy: jasmine.SpyObj<Router>;
  
  let httpMock: HttpTestingController;
  let httpClient: HttpClient;

  beforeEach(() => {
    routerSpy = jasmine.createSpyObj('Router', ['navigate']);

    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [
        {
          provide: HTTP_INTERCEPTORS,
          useClass: ErrorHandlingInterceptor,
          multi: true,
        },
        { provide: Router, useValue: routerSpy },
      ],
    });

    httpMock = TestBed.inject(HttpTestingController);
    httpClient = TestBed.inject(HttpClient);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should redirect to /login on a 401 Unauthorized error', () => {
    httpClient.get('/api/data').subscribe({
      next: () => fail('should have failed with a 401 error'),
      error: (error: HttpErrorResponse) => {
        expect(error.status).toBe(401);
      }
    });

    const req = httpMock.expectOne('/api/data');
    req.flush('Unauthorized', { status: 401, statusText: 'Unauthorized' });

    expect(routerSpy.navigate).toHaveBeenCalledWith(['/login']);
  });

  it('should redirect to /not-found on a 404 Not Found error', () => {
    httpClient.get('/api/non-existent').subscribe({
      error: (error: HttpErrorResponse) => {
        expect(error.status).toBe(404);
      }
    });

    const req = httpMock.expectOne('/api/non-existent');
    req.flush('Not Found', { status: 404, statusText: 'Not Found' });

    expect(routerSpy.navigate).toHaveBeenCalledWith(['/not-found']);
  });
  
  it('should not redirect on a 500 Internal Server Error', () => {
    httpClient.get('/api/server-error').subscribe({
      error: (error: HttpErrorResponse) => {
        expect(error.status).toBe(500);
      }
    });

    const req = httpMock.expectOne('/api/server-error');
    req.flush('Server Error', { status: 500, statusText: 'Server Error' });

    expect(routerSpy.navigate).not.toHaveBeenCalled();
  });
});