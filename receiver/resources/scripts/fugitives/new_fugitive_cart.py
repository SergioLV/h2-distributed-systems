import requests
from faker import Faker
from random import randint
import time
import logging

logging.basicConfig(format='%(asctime)s %(message)s', encoding='utf-8', level=logging.INFO)
logging.info("======================================")
logging.info("SCRIPT FOR MOCKING NEW FUGITIVE CARTS")
logging.info("======================================")


NEW_FUGITIVES_URL = 'http://192.168.1.111:8081/api/v1/add/fugitive-cart'



fake = Faker()

for i in range(1_000_000):
    data={}
    data['latitude'] = randint(7556,65443)
    data['longitude'] = randint(343,766454)

    logging.info(f'Lat: %s, Long: %s' % (data['latitude'], data['longitude']))

    time.sleep(5)
    res = requests.post(NEW_FUGITIVES_URL, json=data)