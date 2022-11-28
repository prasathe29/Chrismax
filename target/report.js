$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Life123.feature");
formatter.feature({
  "name": "Title of your feature",
  "description": "  I want to use this template for my feature file",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Title of your scenario",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I want to write a step with precondition",
  "keyword": "Given "
});
formatter.match({
  "location": "Life.i_want_to_write_a_step_with_precondition()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "some other precondition",
  "keyword": "And "
});
formatter.match({
  "location": "Life.some_other_precondition()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click logine button",
  "keyword": "When "
});
formatter.match({
  "location": "Life.click_logine_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "check more outcomes with date",
  "keyword": "And "
});
formatter.match({
  "location": "Life.check_more_outcomes_with_date()"
});
formatter.result({
  "status": "passed"
});
});