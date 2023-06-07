import user from './user'
import company from "./company";
import transportOrder from "./transportOrder";
import transportOrderItem from "./transportOrderItem";
export default {
  ...user,
  ...company,
  ...transportOrder,
  ...transportOrderItem
}


