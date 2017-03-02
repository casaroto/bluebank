//our root app component
import {Component, NgModule} from '@angular/core'
import { BrowserModule } from '@angular/platform-browser'

// import ng2-bootstrap alerts module
import { AlertModule } from 'ng2-bootstrap/ng2-bootstrap';

import { HttpModule } from '@angular/http';

import {Http, Headers} from '@angular/http';

//import { UserService } from './user.service';

@Component({
  selector: 'my-app',
  template: `
   
<alert type="info">
  <strong>Bluebank</strong> 
  <br> bem vindo <strong>cliente 4</strong>

</alert>

<pre class="card ">CPF&nbsp;<input type="text" ></pre>
<pre class="card ">Agencia&nbsp;<input type="text" ></pre>
<pre class="card ">Conta&nbsp;<input type="text" ></pre>

<div class="btn-group" dropdown>

  <button id="single-button" type="button" class="btn btn-primary" dropdownToggle>
    Contas destino 2222<span class="caret"></span>
  </button>

</div>
<br/><br/>
<button type="button" class="btn btn-primary"
                btnCheckboxTrue="1" btnCheckboxFalse="0">
  Transferir
</button>
teste
    <div>
    <button (click)="loadUser()" type="button">Load profile</button>
    {{ profile | json }}
     <button (click)="getRandomQuote()" type="button">Load profile</button>
  	</div>
	{{ randomQuote }}
  `,
})
export class AppComponent {

  constructor(private http: Http) {
  	
  		var teste = http;
   }
  
	  getRandomQuote() {
	  
	   
	  
	  this.http.get('http://127.0.0.1:8080/bluebackend/service/boasvindas')
	    .map(res => res.text())
	    .subscribe(
	      data => this.randomQuote = data,
	      err => this.logError(err),
	      () => console.log('Random Quote Complete')
	    );
	}
	
	logError(err) {
	  console.error('There was an error: ' + err);
	}
}

@NgModule({
  imports: [BrowserModule, AlertModule, HttpModule],
  declarations: [AppComponent],
  bootstrap: [AppComponent]
})
export class AppModule {



}