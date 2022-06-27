import json

f = open('medicamentos_new_v3.json')

data = json.load(f)

new_data = []

for d in data:

    is_med_in_new_data = d['PRINCIPIO ATIVO'] in [nd['PRINCIPIO ATIVO'] for nd in new_data]

    if not is_med_in_new_data:
        new_data.append(d)

json.dump(new_data[:8000], open('medicamentos_new_v4.json', 'w'))