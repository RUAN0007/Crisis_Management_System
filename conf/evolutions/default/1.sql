# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table account (
  type                      varchar(255) not null,
  account_name              varchar(255),
  password                  varchar(255),
  constraint pk_account primary key (type))
;

create table agency (
  id                        bigint auto_increment not null,
  password                  varchar(255),
  name                      varchar(255),
  phone                     varchar(255),
  email                     varchar(255),
  constraint pk_agency primary key (id))
;

create table call_operator (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  password                  varchar(255),
  phone                     varchar(255),
  constraint pk_call_operator primary key (id))
;

create table dispatch (
  id                        bigint auto_increment not null,
  eventID                   bigint,
  agencyID                  bigint,
  status                    varchar(255),
  dispatch_time             datetime,
  read_time                 datetime,
  solve_time                datetime,
  constraint pk_dispatch primary key (id))
;

create table event (
  id                        bigint auto_increment not null,
  event_type                varchar(255),
  priority                  integer,
  calling_time              datetime,
  postal_code               varchar(255),
  location                  varchar(255),
  caller_phone              varchar(255),
  description               longtext,
  callOperator_id           bigint,
  serviceOperator_id        bigint,
  constraint pk_event primary key (id))
;

create table notification (
  id                        bigint auto_increment not null,
  eventID                   bigint,
  media_type                varchar(255),
  send_time                 datetime,
  constraint pk_notification primary key (id))
;

create table public (
  hand_phone                varchar(255) not null,
  location                  varchar(255),
  name                      varchar(255),
  constraint pk_public primary key (hand_phone))
;

create table service_operator (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  password                  varchar(255),
  phone                     varchar(255),
  constraint pk_service_operator primary key (id))
;

alter table dispatch add constraint fk_dispatch_event_1 foreign key (eventID) references event (id) on delete restrict on update restrict;
create index ix_dispatch_event_1 on dispatch (eventID);
alter table dispatch add constraint fk_dispatch_agency_2 foreign key (agencyID) references agency (id) on delete restrict on update restrict;
create index ix_dispatch_agency_2 on dispatch (agencyID);
alter table event add constraint fk_event_callOperator_3 foreign key (callOperator_id) references call_operator (id) on delete restrict on update restrict;
create index ix_event_callOperator_3 on event (callOperator_id);
alter table event add constraint fk_event_serviceOperator_4 foreign key (serviceOperator_id) references service_operator (id) on delete restrict on update restrict;
create index ix_event_serviceOperator_4 on event (serviceOperator_id);
alter table notification add constraint fk_notification_event_5 foreign key (eventID) references event (id) on delete restrict on update restrict;
create index ix_notification_event_5 on notification (eventID);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table account;

drop table agency;

drop table call_operator;

drop table dispatch;

drop table event;

drop table notification;

drop table public;

drop table service_operator;

SET FOREIGN_KEY_CHECKS=1;

