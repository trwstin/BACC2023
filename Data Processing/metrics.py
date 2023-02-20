import pandas as pd

df = pd.read_csv('./output.csv')
df.replace('', pd.NA, inplace=True)

# Maximum throughput based on algorithm
WEEKLY_THROUGHPUT = 791

# Calculate total travelling time
truckTrips = round(df['Truck Slot 1'].notna().sum(), -3) / 5
transportTimeHrs = int(round(truckTrips * 25 / 60, 0))

# Calculate ratio of truck slots used vs unused
truckUtilRatio = pd.DataFrame(columns=['Column', 'Percentage'])
for col in df.loc[:, 'Truck Slot 1':'Truck Slot 5']:
    percent = round((df[col].count() / len(df)) * 100, 1)
    truckUtilRatio = pd.concat([truckUtilRatio, pd.DataFrame({'Column': [col], 'Percentage': [percent]})], ignore_index=True)
truckUtilRatio.to_csv('truckUtilRatio.csv', index=False)

# Calculate ratio of workstations used vs unused
stationUtilRatio = pd.DataFrame(columns=['Column', 'Percentage'])
for col in df.loc[:, 'Workstation A':'Workstation F']:
    percent = round((df[col].count() / len(df)) * 100, 1)
    stationUtilRatio = pd.concat([stationUtilRatio, pd.DataFrame({'Column': [col], 'Percentage': [percent]})], ignore_index=True)
stationUtilRatio.to_csv('stationUtilRatio.csv', index=False)

# Calculate total time the lots spent in each building
counts_ABC = {}
counts_DEF = {}

for i in range(1, 807):
    count1 = df[['Workstation A', 'Workstation B', 'Workstation C']].apply(lambda x: x.eq(i).sum()).sum()
    count2 = df[['Workstation D', 'Workstation E', 'Workstation F']].apply(lambda x: x.eq(i).sum()).sum()
    counts_ABC[i] = count1
    counts_DEF[i] = count2

counts_df_ABC = pd.DataFrame.from_dict(counts_ABC, orient='index', columns=['count'])
counts_df_DEF = pd.DataFrame.from_dict(counts_DEF, orient='index', columns=['count'])
timeSpentABC = counts_df_ABC['count'].sum()
timeSpentDEF = counts_df_DEF['count'].sum()

timeSpent_dat = {'Time Spent in Building X': [timeSpentABC], 'Time Spent in Building Y': [timeSpentDEF]}
df_time = pd.DataFrame(timeSpent_dat)
df_time.to_csv('timeSpent.csv', index=False)
