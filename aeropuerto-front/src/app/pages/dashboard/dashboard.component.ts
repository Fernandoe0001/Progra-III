import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [MatCardModule, MatIconModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  protected readonly metrics = [
    { label: 'Vuelos activos', value: '42', icon: 'flight_takeoff' },
    { label: 'Pasajeros hoy', value: '8,430', icon: 'groups' },
    { label: 'Puertas en uso', value: '18', icon: 'meeting_room' },
    { label: 'Alertas operativas', value: '3', icon: 'warning' }
  ];
}
