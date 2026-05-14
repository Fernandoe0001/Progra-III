import { Routes } from '@angular/router';

import { LoginComponent } from './pages/login/login.component';
import { DashboardLayoutComponent } from './core/layout/dashboard-layout/dashboard-layout.component';

export const routes: Routes = [

  {
    path: '',
    component: LoginComponent
  },

  {
    path: 'dashboard',
    component: DashboardLayoutComponent
  }

];