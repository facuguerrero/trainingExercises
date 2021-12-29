import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class Solution {
    public static void main(String []args) {
         FractionalKnapsackProblem sol = new FractionalKnapsackProblem();
        int[] wt = { 10, 40, 20, 30 };
        int[] val = { 60, 40, 100, 120 };
        int capacity = 50;
        System.out.println(sol.fractionalKnapsackProblem(val, wt, capacity));

    }
}

class FractionalKnapsackProblem {
  public Double fractionalKnapsackProblem(int[] values, int[] weigths, Integer w) {
      List<Item> itemsList = new ArrayList<>();
      for (int i=0; i<values.length; i++) {
          itemsList.add(new Item(values[i], weigths[i]));
      }
      // sorting the list by value/cost fraction
      Collections.sort(itemsList, Collections.reverseOrder());

      Double totalValue = Double.valueOf(0);
      for (Item item : itemsList) {
          if (item.weight <= w) {
              totalValue += item.cost;
              w -= item.weight;
          } else {
              totalValue += (double)(item.cost * w / item.weight);
              break;
          }
      }
      return totalValue;
  }
}

// item value class
class Item implements Comparable<Item>{
    Integer cost;
    Integer weight;

    // item value function
    public Item(Integer cost, Integer weight) {
        this.cost = cost;
        this.weight = weight;
    }

    public Double getCostPerWeight() {
        return (double)(this.cost / this.weight);
    }

    @Override
    public int compareTo(Item item) {
      return Double.compare(this.getCostPerWeight(), item.getCostPerWeight());
    }

    public String toString() {
        return "Cost: " + this.cost + " | Weight: " + this.weight + " | cw: " + this.getCostPerWeight();
    }

}
