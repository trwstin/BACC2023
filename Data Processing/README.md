# Identifying Production Line Performance Metrics

## Introduction
Using the optimisation algorithm, we simulated an optimised production line to visualise the movement of lots and time spent during each production process. This information is stored in the output.csv file.

## Data Processing
The original output from our optimisation algorithm can be found in the output.txt file. However, this data was difficult to read and comprehend. In order to properly visualise the results, we converted the results into a csv file and populated the respective rows and columns. This was done using Python, and the code for this can be found in the txt_to_csv.py file.

Afterwards, we identified 5 performance metrics to monitor the production line, and used Python to calculate these metrics. The code used for calculating and obtaining these metrics can be found in the metrics.py file.

### Metric 1: Production Volume
By knowing the maximum possible Production Volume, we can make more informed decisions with regards to resource allocation. This will enable greater revenue maximisation and help us predict stock availability for sales. For clarity, this value is displayed as a single number.

### Metric 2: Total Time Spent on Transportation
By knowing how much time is spent travelling per week, we are able to quantify and calculate its associated opportunity costs. This includes time that could have been used for producing more units, or petrol and vehicle maintenance money which could otherwise be saved to increase overall profit. For clarity, this value is displayed as a single number.

### Metric 3: Truck Slot Utilisation
Knowing each truck slot’s utilisation percentage gives insight on the usage frequency of each slot when executing the optimal production strategy. In this case, we see that only 2 of 5 truck slots are gainfully used. Since the truck is underutilised, perhaps the company can use a smaller vehicle which moves faster than a truck and consumes less petrol. A faster vehicle will lead to greater efficiency in the production line, and lower petrol consumption will increase profits. We used a bar chart to present this information as it allowed clear comparison between the various truck slots to show the difference in utility.

### Metric 4: Workstation Utilisation
Knowing each workstation’s utilisation percentage gives insight on the usage frequency of each workstation when executing the optimal production strategy. In this case, most workstations have high utilisation percentage, suggesting low downtime which means great efficiency. However, Workstation D is relatively under-utilized. It may be wise to readjust the steps which Workstation D can handle, such that it is not underutilised. For example, since Building Y lacks a workstation that handles Step 2, Workstation D can take on that role. Likewise, we chose a bar chart to represent this information as it gives an overview of how each workstation is being utilized relative to their counterparts.

### Metric 5: Total Time Lots Spend in Each Building
Knowing the distribution of total time lots spend in each building helps us assess the utility of having a secondary building. In this case, since both buildings are equally utilised for production, having a second building seems to be a reasonable investment as it actively contributes to the efficiency of the production line.

## Building the Dashboard
After getting the necessary metrics, we used PowerBI to design our dashboard. Our goal was to use simple yet functional visuals, to improve clarity of the data presented while minimising visual clutter. We also used blue as the primary colour of our dashboard to match Micron's color scheme.