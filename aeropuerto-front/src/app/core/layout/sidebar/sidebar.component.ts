import { Component, output } from '@angular/core';
import { Router } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { AuthService } from '../../services/auth.service';

interface NavItem {
  label: string;
  icon: string;
  route: string;
}

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [RouterLink, RouterLinkActive, MatButtonModule, MatIconModule, MatListModule],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent {
  readonly navigationClick = output<void>();

  protected readonly navItems: NavItem[] = [
    { label: 'Dashboard', icon: 'dashboard', route: '/dashboard' },
    { label: 'Crear Vuelo', icon: 'add_circle', route: '/vuelos/crear' },
    { label: 'Consultar Vuelo', icon: 'flight', route: '/vuelos/consultar' },
    { label: 'Tripulacion', icon: 'badge', route: '/tripulacion' },
    { label: 'Pasajeros', icon: 'groups', route: '/pasajeros' },
    { label: 'Reportes', icon: 'bar_chart', route: '/reportes' }
  ];

  constructor(
    private readonly authService: AuthService,
    private readonly router: Router
  ) {}

  protected logout(): void {
    this.authService.logout();
    this.navigationClick.emit();
    this.router.navigateByUrl('/login');
  }
}
