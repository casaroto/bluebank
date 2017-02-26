//our root app component
import {Component, NgModule} from '@angular/core'
import { BrowserModule } from '@angular/platform-browser'

// import ng2-bootstrap alerts module
import { AlertModule } from 'ng2-bootstrap/ng2-bootstrap';

import { UserService } from './usr/user.service';

@Component({
  selector: 'my-app',
  template: `
   
<alert type="info">
  <strong>Bluebank</strong> 
  <br> bem vindo <strong>cliente</strong>
</alert>

<pre class="card ">CPF&nbsp;<input type="text" ></pre>
<pre class="card ">Agencia&nbsp;<input type="text" ></pre>
<pre class="card ">Conta&nbsp;<input type="text" ></pre>

<div class="btn-group" dropdown>

  <button id="single-button" type="button" class="btn btn-primary" dropdownToggle>
    Contas destino<span class="caret"></span>
  </button>

</div>
<br/><br/>
<button type="button" class="btn btn-primary"
                btnCheckboxTrue="1" btnCheckboxFalse="0">
  Transferir
</button>

  `,
})
export class AppComponent {
  constructor() {
  }
}

@NgModule({
  imports: [BrowserModule, AlertModule],
  declarations: [AppComponent],
  bootstrap: [AppComponent]
})
export class AppModule {}