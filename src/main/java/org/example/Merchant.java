package org.example;

public class Merchant extends Draw{
    public ListNode head;
    public static class ListNode{
        public Item purchase;
        public ListNode next;
        public Draw drawing;
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

