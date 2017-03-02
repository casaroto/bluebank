import { BluebankSpaPage } from './app.po';

describe('bluebank-spa App', function() {
  let page: BluebankSpaPage;

  beforeEach(() => {
    page = new BluebankSpaPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
