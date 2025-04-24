#!/bin/bash


curl -G http://localhost:8080/api/v1/products \
  --data-urlencode "from=2025-04-01T10:00:00Z" \
  --data-urlencode "till=2025-05-10T10:00:00Z" \
  --data-urlencode "start_id=2" \
  --data-urlencode "asc=true" \
  --data-urlencode "limit=20" \
  --data-urlencode "offset=5" | jq

