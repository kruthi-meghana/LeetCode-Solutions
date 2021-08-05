//Amazon-Design question

/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
*/

class LRUCache {
    
    int capacity;
    DlinkedList head;
    DlinkedList tail;
    Map<Integer, DlinkedList> hmap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DlinkedList(0, 0);
        tail = new DlinkedList(0, 0);
        
        head.pre = null;
        head.post = tail;
        tail.pre = head;
        tail.post = null;
        this.hmap = new HashMap<Integer, DlinkedList>();
    }
    
    public int get(int key) {
        DlinkedList dp = this.hmap.get(key);
        if(dp == null) return -1;
        dp.update();
        return dp.value;
    }
    
    public void put(int key, int value) {
        
        DlinkedList dp = this.hmap.get(key);
        if(dp == null) {
            if(capacity == 0) return;
            
            dp = new DlinkedList(key, value);
            if(capacity == this.hmap.size()) {
                DlinkedList node = tail.pre;
                node.remove();
                this.hmap.remove(node.key);
            }
            dp.append();
            this.hmap.put(key, dp);
        } else {
            dp.value =value;
            dp.update();
        }
        
    }
    
	class DlinkedList {

		int key;
        int value;
        DlinkedList pre;
        DlinkedList post;
        
        public DlinkedList(int key, int value) {
            
            this.key = key;
            this.value = value;
            
        }
        
        public void append() {
            this.pre = head;
            this.post = head.post;
            head.post.pre = this;
            head.post = this;
        }
        
        public void remove() {
            this.post.pre = this.pre;
            this.pre.post = this.post;
        }
        
        public void update() {
            this.remove();
            this.append();
        }


	}



}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
