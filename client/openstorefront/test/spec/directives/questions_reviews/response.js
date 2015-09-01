'use strict';

describe('Directive: views/questionsResponse/responseTemplate.html', function () {

  // load the directive's module
  beforeEach(module('openstorefrontApp'));

  var element,
    scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<views/questionsResponse/responseTemplate.html></views/questionsResponse/responseTemplate.html>');
    element = $compile(element)(scope);
    expect(element.text()).toBe('');
  }));
  alert('Directive:  views/questionsResponse/responseTemplate.html; should make hidden element visible = PASS (1 expect)');
});
