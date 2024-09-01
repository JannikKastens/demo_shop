import { Routes } from '@angular/router';
import { ProductListComponent } from './features/product/product-list/product-list.component';
import { CartComponent } from './features/cart/cart/cart.component';
import { CheckoutComponent } from './features/checkout/checkout/checkout.component';
import { UserProfileComponent } from './features/user/user-profile/user-profile.component';

export const routes: Routes = [
  { path: '', redirectTo: '/products', pathMatch: 'full' },
  { path: 'products', component: ProductListComponent },
  { path: 'cart', component: CartComponent },
  { path: 'checkout', component: CheckoutComponent },
  { path: 'user-profile', component: UserProfileComponent },
];
