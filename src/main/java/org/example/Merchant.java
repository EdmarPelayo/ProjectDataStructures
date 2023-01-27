package org.example;

public class Merchant {
    public ListNode head;
    public static class ListNode{
        public Item purchase;
        public ListNode next;
        public ListNode(Item purchase){
            this.purchase = purchase;
            this.next = null;
        }
    }
    public static class Item {
        public String itemName;
        public double itemCost;

        public Item(String itemName, int itemCost){
            this.itemName = itemName;
            this.itemCost = itemCost;
        }



    }

}

