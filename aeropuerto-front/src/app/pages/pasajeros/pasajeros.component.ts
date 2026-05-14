import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';

@Component({
  selector: 'app-pasajeros',
  standalone: true,
  imports: [MatCardModule, MatIconModule, MatListModule],
  templateUrl: './pasajeros.component.html',
  styleUrl: './pasajeros.component.css'
})
export class PasajerosComponent {}
