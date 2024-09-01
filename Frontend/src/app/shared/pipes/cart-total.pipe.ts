import { Pipe, PipeTransform } from '@angular/core';
import { CartItem } from '../../core/services/cart.service';

@Pipe({
  name: 'cartTotal',
  standalone: true,
})
export class CartTotalPipe implements PipeTransform {
  transform(items: CartItem[]): number {
    return items.reduce((total, item) => total + item.price * item.quantity, 0);
  }
}
