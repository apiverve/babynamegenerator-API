Baby Name Generator API
============

Baby Name Generator is a simple tool for generating baby names. It returns a list of baby names.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Javascript Wrapper for the [Baby Name Generator API](https://apiverve.com/marketplace/api/babynamegenerator)

---

## Installation
	npm install @apiverve/babynamegenerator --save

---

## Configuration

Before using the babynamegenerator API client, you have to setup your account and obtain your API Key.  
You can get it by signing up at [https://apiverve.com](https://apiverve.com)

---

## Usage

The Baby Name Generator API documentation is found here: [https://docs.apiverve.com/api/babynamegenerator](https://docs.apiverve.com/api/babynamegenerator).  
You can find parameters, example responses, and status codes documented here.

### Setup

```
var babynamegeneratorAPI = require('@apiverve/babynamegenerator');
var api = new babynamegeneratorAPI({
    api_key: [YOUR_API_KEY],
    secure: true //(Optional, defaults to true)
});
```

---


### Perform Request
Using the API client, you can perform requests to the API.

###### Define Query

```
var query = {
  gender: "male",
  count: 1
};
```

###### Simple Request (using Callback)

```
api.execute(query, function (error, data) {
    if (error) {
        return console.error(error);
    } else {
        console.log(data);
    }
});
```

###### Example Response

```
{
  "status": "ok",
  "error": null,
  "data": {
    "count": 10,
    "names": [
      {
        "firstName": "Natalie",
        "middleName": "Kay",
        "fullName": "Natalie Kay"
      },
      {
        "firstName": "Rosa",
        "middleName": "Theresa",
        "fullName": "Rosa Theresa"
      },
      {
        "firstName": "Mae",
        "middleName": "Ellen",
        "fullName": "Mae Ellen"
      },
      {
        "firstName": "Lucia",
        "middleName": "Toni",
        "fullName": "Lucia Toni"
      },
      {
        "firstName": "Carrie",
        "middleName": "Bonnie",
        "fullName": "Carrie Bonnie"
      },
      {
        "firstName": "Samantha",
        "middleName": "Roberta",
        "fullName": "Samantha Roberta"
      },
      {
        "firstName": "Gwendolyn",
        "middleName": "Constance",
        "fullName": "Gwendolyn Constance"
      },
      {
        "firstName": "Flora",
        "middleName": "Opal",
        "fullName": "Flora Opal"
      },
      {
        "firstName": "Terry",
        "middleName": "Linda",
        "fullName": "Terry Linda"
      },
      {
        "firstName": "Clara",
        "middleName": "Lora",
        "fullName": "Clara Lora"
      }
    ]
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2024 APIVerve, and Evlar LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.