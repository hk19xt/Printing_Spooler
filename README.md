# Printing_Spooler
This program is running a printing spooler accepting a lot of users based on their priorities.
This program has a goal to learn a dynamically sized structure in order to accept, hold, and release printing jobs. This program is focusing on the concept of nodes.

How to run this program:
1) There are three classes in this file: Node.class, Print.class, PrintSpooler.class.
2) When you run it, the BasicForm display will be popped up.
3) Put information, including description, sender, the number of pages, and priorities, and click the 'Add Job' button. 
4) Then, ASCIIDisplayer will be popped up with your input.
5) When you click the 'Print Next' button, it will print the recent job.
6) When you click the 'Check' button, it will check the entire print job.
7) When you click the 'Quit' button, it will exit the program.

Finally, this program has a priority.
1) Students have first priority, so their printing jobs are prioritized over any staff and faculty jobs.
2) Staff has second priority, so their printing jobs are prioritized over faculty jobs.
3) Faculty has the longest waiting lists because they have flexible due dates.
4) However, if they have the same category in students, staff or faculty, then first-come and first-serve will be applied.

This program is one of individual computer science assignments using Dr.Java.
