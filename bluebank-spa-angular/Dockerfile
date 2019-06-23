FROM node:10
WORKDIR /app
COPY package.json /app
RUN npm install && npm install -g @angular/cli@1.2.5
COPY . /app
CMD npm start
EXPOSE 4200


