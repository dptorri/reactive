#!/bin/bash

curl -X POST "http://localhost:8080/employees" \
-H "Accept: application/json" \
-H "Content-Type: application/json" \
--data-binary @- <<DATA
{
  "id": 1,
  "name": "Kate",
  "jobPosition": "dev"
}
DATA