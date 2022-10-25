FROM python:latest

WORKDIR /scripts

COPY requirements.txt ./

COPY new_sales.py ./


RUN pip install --no-cache-dir --upgrade pip \
  && pip install --no-cache-dir -r requirements.txt

CMD [ "python", "./new_sales.py"]