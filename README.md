# aw-instaritter-talg-service


``` http://localhost:8081/api/swagger-ui.html#/ ``

## Endpoints:

#### GET /api/photos

Exemple to produces:

``` 
[
  {
    "dateTime": "2018-07-26T03:05:54.226Z",
    "description": "string",
    "id": 0,
    "image": "string"
  }
] 

```

#### GET /api/photos/{id}

Exemple to produces:

```
{
     "dateTime": "2018-07-26T03:05:54.258Z",
     "description": "string",
     "id": 0,
     "image": "string",
     "links": [
       {
         "deprecation": "string",
         "href": "string",
         "hreflang": "string",
         "media": "string",
         "rel": "string",
         "templated": true,
         "title": "string",
         "type": "string"
       }
     ]
   } 
``` 
   
#### PUT /api/photos

Exemple to consumes:
``` 
{
      "dateTime": "2018-07-26T03:05:54.247Z",
      "description": "string",
      "id": 0,
      "image": "string"
    } 
```