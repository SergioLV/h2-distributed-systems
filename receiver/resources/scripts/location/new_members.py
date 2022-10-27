from pickletools import pyint
import requests
from faker import Faker
from random import randint
import random
from datetime import datetime
import time
import logging

logging.basicConfig(format='%(asctime)s %(message)s', encoding='utf-8', level=logging.INFO)
logging.info("==============================")
logging.info("SCRIPT FOR MOCKING NEW MEMBERS")
logging.info("==============================")


NEW_MEMBERS_URL = 'http://192.168.1.111:8081/api/v1/add/memberRequest'


fake = Faker()

for i in range(1_000_000):
    data={}
    data['name'] = fake.first_name()
    data['lastName'] = fake.last_name()
    data['id'] = randint(453453,645645)
    data['email'] = fake.email()
    data['cartPlate'] = fake.license_plate()
    data["isPremium"] = random.choice(["true", "false"])
    logging.info(f'Name: %s, email: %s, isPremium: %s' % (data['name'], data['email'], data['isPremium']))

    time.sleep(1)
    res = requests.post(NEW_MEMBERS_URL, json=data)