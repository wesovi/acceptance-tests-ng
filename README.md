## Synopsis

This is a simple proof of concept that will guide us on how to do acceptance tests on a dockerized environment.
This is a maven project with 3 submodules, a couple of spring boot micro services(one micro service  inserts data into the database and the other one extract it) and the third submodule will show us how we can run our cucumber acceptance tests against a a dockerized environment.

Each micro service also includes a few integration tests developed with RestAssured (these tests will run in a local environment and using standalone server.)

## Code Example
Below a cucumber scenario
	
	Scenario: Getting the list of items when the database is empty
		Given a database with no items 
		When we ask for the list of items
		Then we obtain no items

## Motivation

Being focused on the best way to do acceptance tests. Run acceptance tests in a local environment could be risky since we are not running our tests in a production environment. Docker allows us to do acceptance tests on a real environment since our own workstation.  

## Installation

Just clone the project and let it go!

## API Reference
TODO

## Tests
* Extraction micro service (ms.extraction):
	* **mvn verify -Pintegration** : Run integration testing.
* Insertion micro service (ms.insertion):
	* **mvn verify -Pintegration** : Run integration testing.
* Acceptance tests (ms.at):
	* **mvn verify**: Run acceptance tests on a dockerized environment.
 

## Contributors

**Iván Corrales Solera <developer@wesovi.com>** 
* Site - http://www.wesovi.com
* Linkedin - https://es.linkedin.com/pub/iván-corrales-solera
* Twitter - https://twitter.com/Wesovi

## License

The MIT License (MIT)

Copyright (c) 2015 Iván Corrales Solera

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
