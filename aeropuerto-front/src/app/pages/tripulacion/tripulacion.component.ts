import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-tripulacion',
  standalone: true,
  imports: [MatCardModule, MatIconModule],
  templateUrl: './tripulacion.component.html',
  styleUrl: './tripulacion.component.css'
})
export class TripulacionComponent {}
