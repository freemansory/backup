import { Component } from '@angular/core';
import { ScriptService } from './services/script.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'punier-de-berlin';

  constructor(private script: ScriptService) {
    this.script.load('main', 'script', 'timer', 'feather', 'bootstrap', 'jquery-ui')
  }
}
