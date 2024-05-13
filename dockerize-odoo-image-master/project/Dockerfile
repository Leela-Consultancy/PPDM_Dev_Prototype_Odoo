FROM odoo:15.0

USER root

ENV DEBIAN_FRONTEND=noninteractive \
    LANG=C.UTF-8

RUN apt-get update \
    && apt-get install --no-install-recommends -y \
        python3-wheel \
        python3-dev \
        openssl \
        build-essential \
        libssl-dev \
        libxrender-dev \
        git-core \
        libx11-dev \
        libxext-dev \
        libfontconfig1-dev \
        libfreetype6-dev \
        fontconfig \
        libffi-dev \
        libldap2-dev \
        libsasl2-dev  # Install libsasl2-dev for sasl.h

RUN rm -rf /var/lib/apt/lists/*.*

COPY requirements.txt ./
COPY ./custom_addons /mnt/extra-addons
COPY ./ngnix /etc/nginx

RUN pip3 install -r requirements.txt

USER odoo

WORKDIR /mnt/extra-addons

COPY . .
