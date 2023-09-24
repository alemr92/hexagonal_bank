####### ATTENTION!! : #######
THIS PROJECT IS A FORK FROM 
https://jivimberg.io/blog/2020/02/01/hexagonal-architecture-on-spring-boot/
WHO EXPLAIN WHAT IS HEXAGONAL ARCHITECTURE WITH THIS EXAMPLE. ALL CREDIT FOR HIM.
I only make some changes for my personal use and practice with hexagonal architecture
## Bank Demo API

![HexagonalArchitecture-impl](https://github.com/alemr92/hexagonal_bank/assets/30073503/15677aa6-db50-4983-9b0e-8ad822a7bc46)


## Features

- Check money
- Deposit money
- Withdraw money

## Access

```bash
http://localhost:8080/account
```

## Endpoints
#### GET:
```bash
/{id}
```
#### POST
```bash
/{id}/deposit/{amount}
/{id}/withdraw/{amount}
```

#### PUT
#### DELETE:

## Authentication

## Tests

## FAQ

#### Do I need to install anything?

MongoDB with a database called bank

