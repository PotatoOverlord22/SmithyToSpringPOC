1. Generate smithy models by going in the smithy folder and running
`smithy build`

2. Generate from the root folder Java Spring models and interfaces with openapi:
```
openapi-generator generate \
  -i smithy/build/smithy/source/openapi/SmithyPOC.openapi.json \
  -g spring \
  -o SpringApp/generated \
  --package-name com.uaic.smithypoc.generated \
  --model-package com.uaic.smithypoc.generated.model \
  --api-package com.uaic.smithypoc.generated.api \
  --additional-properties=useTags=true,useJakartaEe=true
```