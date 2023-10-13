
# Wishlist service

Small project focusing on the feature of adding, retrieving and removind products from a user's wishlist


## API doc

#### Retrieve all products from a user wishlist

```http
  GET /wishlist/products?userId=e9a2507d-0c3e-477c-ac2f-b738bcd5ff89
```

| Param   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `userId` | `UUID` | **Required**. User Id


#### Retrieve all wishlist by userId with User and Product info

```http
  GET /wishlist?userId=e9a2507d-0c3e-477c-ac2f-b738bcd5ff89
```

| Param   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `userId` | `UUID` | **Required**. User Id


#### Check if product is wishlisted by user

```http
  GET /wishlist?userId=e9a2507d-0c3e-477c-ac2f-b738bcd5ff89&productId=9ebdbaf3-3ca3-4eef-9bab-5caa83652240
```

| Param   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `userId` | `UUID` | **Required**. User Id
| `productId` | `UUID` | **Required**. Product Id

#### Add product to user wishlist

```http
  POST /wishlist/products
```

{

	"userId": "e9a2507d-0c3e-477c-ac2f-b738bcd5ff89", 
	"productId": "9ebdbaf3-3ca3-4eef-9bab-5caa83652240"
}

#### Remove product from user wishlist

```http
  DELETE /wishlist/products
```

{

	"userId": "e9a2507d-0c3e-477c-ac2f-b738bcd5ff89", 
	"productId": "9ebdbaf3-3ca3-4eef-9bab-5caa83652240"
}
