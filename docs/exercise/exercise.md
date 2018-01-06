# WebEngineering Module, Graded Exercise

## Commit Proposal

Matriculation Number: 16-967-671

Project idea short description:

Currently there are many platforms for purchasing or selling products, such as ebay; ricardo or flohmarkt.ch, for private and commercial users respectively.
These websites are all based on monetary trades where the value of an item is derived from production and material costs as well as other efforts.
While there are "Flohmarkets" where the cost of an item is mostly based on the sellers estimate, the market is relatively dry in respect to different ways of trading.

The app to be developped is pursuing a "barter" approach where items are not payed with money, but other items.
The seller offers an item and specifies what he wants to _trade_ it for.
The basic assumption is that many people have items they no longer need or want but for which the monetary incent might be too low to attend a flohmarkt (which can be a lot of work). In addition there might be things that would like to acquire which are of equal value of what they want to sell. Instead of selling these used products for little money, they could be _exchanged_ with someone.

One myShare, these people can make adverts and state what they are willing to share for. Vice versa people can search adverts and accept offers to adverts. If both individuals agree on the conditions, the can make a deal.


## Project confirmation

confirmed.

This is a cool idea.
The details of such platforms can get rather complicated. Start simple and concentrate on the core business.
Finding a good solution for matching supply and demand will be challenging enough.
You best leave security and protection against misuse aside at the beginning.
Start small. Extend from there. Always keep the system running.


## Project delivery <to be filled by student>

How to start the project: (if other than `grailsw run-app`)

How to test the project:  (if other than `grailsw test-app`)

Project description:'/about'

External contributions: Grails tutorials page on i18n

Other comments: During development I realised that offering categories doesn't make too much sense. The offer should be
concrete as opposed to something vague as saying what kind of thing you'd offer for a given article. Therefore
I removed that feature and implemented a feature that allows a user to offer articles that she/he added to the portal.

I'm particular proud of: See /about page for full list


## Project grading 

Description as part of the app (about) instead of static html. Some validity issues with
element nesting and charset setting.
The application works fine.

Functionality covers basic CRUD operations for a domain with 1:m and m:n relations, 
specialized list views, internationalization (at least partly), and role based security.

Engingeering:
Commit log is ok (started from scratch, some commits from user "UNKNOWN"?).
No Tests. Some issues with html validity. Nice use of taglibs (still, some duplication
remains in the views). Good use of Web MVC.

I award three extra points for the particular effort of using spring security and 
internationalization.

Congratulations!
You created a nice, multi-user, DB-backed, distributed, multi-language web application
all by yourself from scratch. 
Given the time contraints, many professional web developers would find it difficult to
achieve the same.

Total grade: 6.0

