#!/bin/bash

curl -X POST "http://localhost:8080/persons" \
-H "Accept: application/json" \
-H "Content-Type: application/json" \
--data-binary @- <<DATA
{
  "id": 1,
  "name": "Kate"
}
DATA