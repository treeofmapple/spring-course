import { ApplicationConfig, ErrorHandler, provideBrowserGlobalErrorListeners, provideZoneChangeDetection } from '@angular/core';
import { PreloadAllModules, provideRouter, withComponentInputBinding, withPreloading, withViewTransitions } from '@angular/router';

import { routes } from './app.routes';
import { GlobalErrorHandler } from './core/services/global-error-handler';
import { HTTP_INTERCEPTORS, provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { ErrorHandlingInterceptor } from './core/interceptors/error-handling-interceptor';

export const appConfig: ApplicationConfig = {
  providers: [
    
    {
      provide: ErrorHandler,
      useClass: GlobalErrorHandler,
    },

    {
      provide: HTTP_INTERCEPTORS,
      useClass: ErrorHandlingInterceptor,
      multi: true
    },

    provideHttpClient(withInterceptorsFromDi()),
    provideBrowserGlobalErrorListeners(),
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes, 
      withComponentInputBinding(),
      withPreloading(PreloadAllModules),
      withViewTransitions(),
    ),

  ]

};
