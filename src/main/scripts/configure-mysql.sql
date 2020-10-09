
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

#Create DBs, one development and one production
CREATE DATABASE lgwarlick_dev;
CREATE DATABASE lgwarlick_prod;

#Create service accounts for each db
CREATE USER 'lgwarlick_dev_user'@'localhost' IDENTIFIED BY 'lgwarlick';
CREATE USER 'lgwarlick_prod_user'@'localhost' IDENTIFIED BY 'lgwarlick';
#Wildcard
CREATE USER 'lgwarlick_dev_user'@'%' IDENTIFIED BY 'lgwarlick';
CREATE USER 'lgwarlick_prod_user'@'%' IDENTIFIED BY 'lgwarlick';


#grants for dev user
GRANT SELECT ON lgwarlick_dev.* to 'lgwarlick_dev_user'@'localhost';
GRANT INSERT ON lgwarlick_dev.* to 'lgwarlick_dev_user'@'localhost';
GRANT DELETE ON lgwarlick_dev.* to 'lgwarlick_dev_user'@'localhost';
GRANT UPDATE ON lgwarlick_dev.* to 'lgwarlick_dev_user'@'localhost';

#grants for production user
GRANT SELECT ON lgwarlick_prod.* to 'lgwarlick_prod_user'@'localhost';
GRANT INSERT ON lgwarlick_prod.* to 'lgwarlick_prod_user'@'localhost';
GRANT DELETE ON lgwarlick_prod.* to 'lgwarlick_prod_user'@'localhost';
GRANT UPDATE ON lgwarlick_prod.* to 'lgwarlick_prod_user'@'localhost';

#grants for wildcards
GRANT SELECT ON lgwarlick_dev.* to 'lgwarlick_dev_user'@'%';
GRANT INSERT ON lgwarlick_dev.* to 'lgwarlick_dev_user'@'%';
GRANT DELETE ON lgwarlick_dev.* to 'lgwarlick_dev_user'@'%';
GRANT UPDATE ON lgwarlick_dev.* to 'lgwarlick_dev_user'@'%';
GRANT SELECT ON lgwarlick_prod.* to 'lgwarlick_prod_user'@'%';
GRANT INSERT ON lgwarlick_prod.* to 'lgwarlick_prod_user'@'%';
GRANT DELETE ON lgwarlick_prod.* to 'lgwarlick_prod_user'@'%';
GRANT UPDATE ON lgwarlick_prod.* to 'lgwarlick_prod_user'@'%';