# WellD code challenge

# Pattern Recognition

RESTful web service that identifies collinear points in a 2D space.

# Requirements
- Java 17
- Maven 3.8.1+
# API Endpoints
**Base path** `localhost:8080`

### Add a point
**POST** `/point`

```json
 {
    "x": 2,
    "y": 4
 }
```
### Get all points
**GET** `/space`

### Get lines with at least N points
**GET** `/lines/{n}`

### Find lines containing specific points
**POST** `/find-lines`

```json
[
 { "x": 2, "y": 4 },
 { "x": 4, "y": 6 }
]
```

### Delete all points
**DELETE** `/space`