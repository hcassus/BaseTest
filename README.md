# BaseTest
A basic automated test

https://codeship.com/projects/c29ad630-b993-0133-9727-4a1410bd443d/status?branch=master

## Test Construction

The test was build using PageFactory and Page Objects Model and segmenting the classes in three main packages:
- Test Pages (The page objects and elementar interactions with them)
- Steps (The actions composed by a set of page elementar interactions, allowing to plug a BDD framework easily)
- Tests (The actual test case, with setup and teardown for the tests)

## String navigation

Although it may seem a bit odd to use strings to navigate in the projects, it makes sense where options are abundant in order not to bloat our page objects repository. Besides that, building a testcase becomes easier since the inspection of the element is merely visual, with no need of inspecting the DOM.

The options we can navigate using strings in this project are:

- Top menu options, using the tooltip text as a reference
- Settings page options, using the link text as a reference
- Tabs on the options selected on Settings menu
- Accessing lead details (using lead name for that)
- Lead Status Name edit (using status name for that)

## XPath selection

Some of the options were hard to select with other selectors, so some of the XPath strings may look too long or complex.
By having access to the source, new locators could be introduced in order to improve element handling precision.

## Test teardown

Since I'm using the production environment for the test, my teardown method reverts the change I've made in order to permit repeated executions

## Segmentation of Test Cases

Although I respected the requested test scenario, my suggestion wuold be to segment it in at least two scenarios to avoid extra test scope for the test case. If the purpose of the test is to validate the change of the status name, the record used in the process should be already created, so that eventual errors in creating a lead wouldn't stop me from verifying the change of a lead status name is reflected on the lead. Each testcase should be responsible for a single assertion scope.

## Observations on the system

When you try to create a lead only with the first name, we are informed that we need to provide a last name OR a company name. But when we inform only the company name and try to save, we get a "Lead didn't save" message, which forbids us to save it, receiving this response from the backend (without any indication on the front end)
``` 
{"success":false,"metadata":{},"errors":{"base":[{"type":"required","message":"Please provide a last name"}]}}
```
To validate these requests and form combinations, a subcutaneous test could be crafted and we'd cover eventual impacts on form changes.

Besides that, on the Lead Status Name edit page, it is possible to observe that we have multiple elements using the same id (using xpath //*[@id = 'name']), which is agianst W3C recomendations (https://www.w3.org/TR/html-markup/global-attributes.html @ id section). if there's a need of identifying a group of elements with the same handle, the class attribute is preferred.

