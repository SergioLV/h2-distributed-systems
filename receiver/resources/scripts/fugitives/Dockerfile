FROM python:latest

WORKDIR /scripts

COPY requirements.txt ./

COPY new_fugitive_cart.py ./

RUN pip install --no-cache-dir --upgrade pip \
  && pip install --no-cache-dir -r requirements.txt


CMD [ "python", "./new_fugitive_cart.py"]