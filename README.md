# BACC2023

Question: 
Find the maximum throughput in a week assuming both building operate 168 hours a week.

Background:

Each lot is required to process these 6 steps sequentially (1 -> 2 -> 3 -> 4 -> 5  -> 6) and each workstation is only capable to process certain steps. Skipping of step is not allowed.

All the lots will start from Building X, and after completing all the steps, they can be in either building for shipment.

Each lot is not allowed to process at 2 or more workstations at any point of time.

Each workstation can only process 1 lot at one time and is not allowed to run different steps concurrently.

You may assume that the lot is always available to start at Building X.

Building X has Workstation Groups A, B, C
Building Y has Workstation Groups D, E, F

The transportation time within the same building is assumed to be negligible. However, cross
building transportation time is 25 mins.

Transportation is done by a single truck which can only be at either building at any point in time. The truck can only hold 5 lots at one time.

Workstation Group A can run Steps 1 and 3
Workstation Group B can run Steps 2 and 6
Workstation Group C can run Steps 2 and 5
Workstation Group D can run Steps 1 and 4
Workstation Group E can run Steps 1 and 3 and 5
Workstation Group F can run Steps 4 and 6

Workstation A takes 5 mins to run Step 1 and 10 mins to run Step 3
Workstation B takes 15 mins to run Step 2 and 10 mins to run Step 6
Workstation C takes 15 mins to run Step 2 and 10 mins to run Step 5
Workstation D takes 5 mins to run Step 1 and 15 mins to run Step 4
Workstation E takes 5 mins to run Step 1 and 5 mins to run Step 3 and 15 mins to run Step 5
Workstation F takes 10 mins to run Step 4 and 10 mins to run Step 6

Notes:
- All lots undergo Step 2 in Building X
- All lots undergo Step 4 in Building Y

Alogrithm:
Workstation Groups:
- Workstation A prioritise carrying out Step 3 over Step 1
- Workstation B prioritise carrying out Step 6 over Step 2
- Workstation C prioritise carrying out Step 5 over Step 2
- Workstation D prioritise carrying out Step 4 over Step 1
- Workstation E prioritise carrying out Step 5 over Step 3 over Step 1
- Workstation F prioritise carrying out Step 6 over Step 4

Transportation:
- Truck always moving
- Moving from Building X to Y:
- Prioritise moving all Lots awaiting Step 4
    - Fill remaining space with Lots awaiting Step 3
    - Fill remaining space with Lots awaiting Step 1
- Moving from Building Y to X:
    - Prioritise moving all Lots awaiting Step 2
    - Fill remaining space with Lots awaiting Step 5
    - Fill remaining space with Lots awaiting Step 6
    - Move off even is there still is space

Program:
Lot:
- Has an ID number for tracking
- Latest step it has undergone (0,1,2,3,4,5,6)
Building:
- Has an inventory made of 7 ImList objects, one for each type of Lot (eg. lots that have completed Step 1)
    - Finished Step 0
    - Finished Step 1
    - Finished Step 2
    - Finished Step 3
    - Finished Step 4
    - Finished Step 5
    - Finished Step 6
- Has method add(Lot x) to add a Lot to its inventory
- Has method take(int a) to remove a Lot of specified Step completed and pass it on
Machine (Workstation group):
- Has an ID
- Has a time to indicate when it is next available
- Has a one Lot inventory indicating the Lot that it is currently processing (has a Lot with ID 0 as a placeholder if it is currently not processing any Lots)
- Has method changeTime(int x) to update Machine’s next available time
Truck:
- Has an inventory, an ImList of maximum 5 Lots
- Has a time attribute indicating when it is next at either Building
- Has a location attribute indicating which Building it will be at, at the time (1 = Building X, 2 = Building Y)
- Has a move(ImList<Lot> x) method to initiate movement of the Truck from one Building to the other with the given new inventory

Main Method:
For every 5 minutes:
- Check if Truck is at either Building
    - If it is, load it and send it off
- Check if all Machines are working
    - If not, check Building inventory for Lots awaiting Steps and attach them to Machines accordingly
- Output state of all Machines and Truck to be used for filling of spreadsheet
