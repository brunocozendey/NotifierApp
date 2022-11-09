USE notifications;
CREATE TABLE notificacao (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  id_conta INTEGER(10) NOT NULL,
  data DATE NOT NULL,
  valor DOUBLE PRECISION
);

INSERT INTO notifications.notificacao VALUE (1,123,'2022-01-01',200);
INSERT INTO notifications.notificacao VALUE (2,321,'2022-01-01',100);