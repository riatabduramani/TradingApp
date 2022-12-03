## Trading App

This project was a blackbox for me, based on the requirements tried to decouple the idea and give a solution, but I'll be happy to discuss and give more detailed idea once I understand fully the requirements.

### What I have introduced in this solution?

In order to have easy maintenance, I decoupled the existing hard coded one and made it much more extendable.

Introduced two endpoints
- saving signal specifications
  - can be used internally, 
  - haven't used any authentication
- receiving signal 
  - GET method
  - returns 200 when signal is present

This endpoint helps to create signals by sending a JSON and save in database (in-memory db, used for challenging purposes);
````
curl --location --request POST 'http://localhost:8080/create' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "signal": 16,
    "type": "SETUP",
    "calculate": true,
    "specificationss" : [{"param": 1, "value": 60}, {"param": 2, "value": 50}, {"param": 3, "value": 30}]
    }'
````

And, this one is to call the signals based on signal ID.
```
curl --location --request GET 'http://localhost:8080/api/v1/signal/1'
```

Thank you for reviewing my code!