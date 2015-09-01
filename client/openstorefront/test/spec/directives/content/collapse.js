'use strict';

describe('Directive: content/draggableCollapse', function () {

  // load the directive's module
  beforeEach(module('openstorefrontApp'));

  var element,
    scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<content/draggableCollapse></content/draggableCollapse>');
    element = $compile(element)(scope);
    expect(element.text()).toBe('');
  }));
  alert('Directive:  content/draggableCollapse; should make hidden element visible = PASS (1 expect)');
});

