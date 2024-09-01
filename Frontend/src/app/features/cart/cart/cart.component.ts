import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';
import { CartService, CartItem } from '../../../core/services/cart.service';
import { CartTotalPipe } from '../../../shared/pipes/cart-total.pipe';

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [CommonModule, CartTotalPipe],
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss'],
})
export class CartComponent implements OnInit {
  cartItems$: Observable<CartItem[]>;

  constructor(private cartService: CartService) {
    this.cartItems$ = this.cartService.getCart();
  }

  ngOnInit(): void {}

  removeItem(productId: number): void {
    this.cartService.removeFromCart(productId);
  }

  updateQuantity(productId: number, quantity: number): void {
    this.cartService.updateQuantity(productId, quantity);
  }
}
