use `case`;
INSERT INTO `case`.`customer` ( `name_customer`, `date_of_birth`, `gender`, `id_card`, `phone_number`, `email`, `address`, `id_cus_type`) VALUES ( 'Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng', 5);
INSERT INTO `case`.`customer` (`name_customer`, `date_of_birth`, `gender`, `id_card`, `phone_number`, `email`, `address`, `id_cus_type`) VALUES ( 'Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị', 3);
INSERT INTO `case`.`customer` ( `name_customer`, `date_of_birth`, `gender`, `id_card`, `phone_number`, `email`, `address`, `id_cus_type`) VALUES ( 'Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh', 1);
INSERT INTO `case`.`customer` ( `name_customer`, `date_of_birth`, `gender`, `id_card`, `phone_number`, `email`, `address`, `id_cus_type`) VALUES ( 'Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng', 1);
INSERT INTO `case`.`customer` ( `name_customer`, `date_of_birth`, `gender`, `id_card`, `phone_number`, `email`, `address`, `id_cus_type`) VALUES ( 'Hoàng Trần Nhi Nhi', '1995-12-09',0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai', 4);
INSERT INTO `case`.`customer` (`name_customer`, `date_of_birth`, `gender`, `id_card`, `phone_number`, `email`, `address`, `id_cus_type`) VALUES ( 'Tôn Nữ Mộc Châu', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng', 4);
INSERT INTO `case`.`customer` ( `name_customer`, `date_of_birth`, `gender`, `id_card`, `phone_number`, `email`, `address`, `id_cus_type`) VALUES ( 'Nguyễn Mỹ Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh', 1);
INSERT INTO `case`.`customer` ( `name_customer`, `date_of_birth`, `gender`, `id_card`, `phone_number`, `email`, `address`, `id_cus_type`) VALUES ( 'Nguyễn Thị Hào', '1999-04-08', 0, '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum', 3);
INSERT INTO `case`.`customer` (`name_customer`, `date_of_birth`, `gender`, `id_card`, `phone_number`, `email`, `address`, `id_cus_type`) VALUES ( 'Trần Đại Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi', 1);
INSERT INTO `case`.`customer` (`name_customer`, `date_of_birth`, `gender`, `id_card`, `phone_number`, `email`, `address`, `id_cus_type`) VALUES ( 'Nguyễn Tâm Đắc', '1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng', 2);

INSERT INTO `case`.`rent_type` ( `rent_type_name`) VALUES ( 'year');
INSERT INTO `case`.`rent_type` (`rent_type_name`) VALUES ( 'month');
INSERT INTO `case`.`rent_type` (`rent_type_name`) VALUES ( 'day');
INSERT INTO `case`.`rent_type` (`rent_type_name`) VALUES ( 'hour');

INSERT INTO `case`.`service_type` ( `service_typet_name`) VALUES ( 'Villa');
INSERT INTO `case`.`service_type` (`service_typet_name`) VALUES ( 'House');
INSERT INTO `case`.`service_type` (`service_typet_name`) VALUES ( 'Room');

INSERT INTO `case`.`service` ( `sv_name`, `sv_area`, `sv_cost`, `max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_floor`, `id_rent_type`, `id_service_type`) VALUES ('Villa Beach Front', '25000', '10000000', '10', 'vip', 'Có hồ bơi', '500', '4', 3, 1);
INSERT INTO `case`.`service` (`sv_name`, `sv_area`, `sv_cost`, `max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_floor`, `id_rent_type`, `id_service_type`) VALUES ( 'House Princess 01', '14000', '5000000', '7', 'vip', 'Có thêm bếp nướng', null, '3', 2, 2);
INSERT INTO `case`.`service` (`sv_name`, `sv_area`, `sv_cost`, `max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_floor`, `id_rent_type`, `id_service_type`) VALUES ( 'Room Twin 01', '5000', '1000000', '2', 'normal', 'Có tivi', null, null, 4, 3);
INSERT INTO `case`.`service` (`sv_name`, `sv_area`, `sv_cost`, `max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_floor`, `id_rent_type`, `id_service_type`) VALUES ( 'Villa No Beach Front', '22000', '9000000', '8', 'normal', 'Có hồ bơi', '300', '3', 3, 1);
INSERT INTO `case`.`service` (`sv_name`, `sv_area`, `sv_cost`, `max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_floor`, `id_rent_type`, `id_service_type`) VALUES ( 'House Princess 02', '10000', '4000000', '5', 'normal', 'Có thêm bếp nướng', null, '2', 3, 2);
INSERT INTO `case`.`service` (`sv_name`, `sv_area`, `sv_cost`, `max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_floor`, `id_rent_type`, `id_service_type`) VALUES ( 'Room Twin 02', '3000', '900000', '2', 'normal', 'Có tivi', null, null, 4, 3);
