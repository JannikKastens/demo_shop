import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

export interface Product {
  id: number;
  name: string;
  description: string;
  price: number;
  imageUrl: string;
}

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private products: Product[] = [
    {
      id: 1,
      name: 'Stylish Watch',
      description: 'A modern watch for everyday use',
      price: 99.99,
      imageUrl: 'https://via.placeholder.com/150',
    },
    {
      id: 2,
      name: 'Wireless Earbuds',
      description: 'High-quality sound on the go',
      price: 129.99,
      imageUrl: 'https://via.placeholder.com/150',
    },
    // Add more mock products as needed
  ];

  getProducts(): Observable<Product[]> {
    return of(this.products);
  }
}
