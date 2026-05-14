import { Component } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { RouterLink, RouterLinkActive } from '@angular/router';

interface NavItem {
  label: string;
  icon: string;
  route: string;
}

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [RouterLink, RouterLinkActive, MatIconModule, MatListModule],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent {
  protected readonly navItems: NavItem[] = [
    { label: 'Dashboard', icon: 'dashboard', route: '/dashboard' },
    { label: 'Vuelos', icon: 'flight', route: '/vuelos' },
    { label: 'Pasajeros', icon: 'groups', route: '/pasajeros' },
    { label: 'Tripulacion', icon: 'badge', route: '/tripulacion' },
    { label: 'Abordaje', icon: 'confirmation_number', route: '/abordaje' },
    { label: 'Reportes', icon: 'bar_chart', route: '/reportes' }
  ];
}
