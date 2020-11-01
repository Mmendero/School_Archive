#include <linux/init.h>
#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/list.h>
#include <linux/slab.h>

struct birthday{
	int day;
	int month;
	int year;
	struct list_head list;
};

static LIST_HEAD(birthday_list);



/* This function is called when the module is loaded. */
int birthday_init(void)
{
	
	struct birthday *person, *ptr;
	int i;
	printk(KERN_INFO "Loading Linked List\n");
	for(i = 0; i < 5; i++){
		person = kmalloc(sizeof(*person), GFP_KERNEL);
		person->day = ((i*1000)%30) + 1;
		person->month = ((i*1000)%12) + 1;
		person->year = i + 2000;
		INIT_LIST_HEAD(&person->list);
		list_add_tail(&person->list, &birthday_list);
	}
	printk(KERN_INFO "Loading Done\n");
	
	printk(KERN_INFO "Displaying Birthdays:\n");
	list_for_each_entry(ptr, &birthday_list, list){
		printk(KERN_INFO "Birthday -> Day: %d, Month %d, Year: %d\n", 
		ptr->day,
		ptr->month,
		ptr->year);
	}

      	printk(KERN_INFO "Display Done\n");

       return 0;
}

/* This function is called when the module is removed. */
void birthday_exit(void) {
	struct birthday *ptr, *next;
	
	printk(KERN_INFO "Removing Nodes\n");
	list_for_each_entry_safe(ptr, next, &birthday_list, list){
		printk(KERN_INFO "Removing -> Day: %d, Month %d, Year: %d\n", 
		ptr->day,
		ptr->month,
		ptr->year);
		list_del(&ptr->list);
		kfree(ptr);
	}
	printk(KERN_INFO "Memory Freed\n");
}

/* Macros for registering module entry and exit points. */
module_init( birthday_init );
module_exit( birthday_exit );

MODULE_LICENSE("GPL");
MODULE_DESCRIPTION("Simple Module");
MODULE_AUTHOR("SGG");


