l-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.34 - MySQL Community Server - GPL
-- Server OS:                    macos13
-- HeidiSQL Version:             12.7.0.6850
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for poc_database
CREATE DATABASE IF NOT EXISTS `poc_database` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `poc_database`;

-- Dumping structure for table poc_database.animal
CREATE TABLE IF NOT EXISTS `animal` (
  `animal_id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `species` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `health_status` text COLLATE utf8mb4_unicode_ci,
  `created_at` datetime NOT NULL DEFAULT (now()),
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`animal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table poc_database.animal: ~5 rows (approximately)
INSERT INTO `animal` (`animal_id`, `name`, `species`, `health_status`, `created_at`, `updated_at`, `deleted_at`) VALUES
	(1, 'Igor', 'Iguana', 'Changes colours often.', '2024-06-02 23:02:49', '2024-06-04 14:12:21', NULL),
	(2, 'Bob', 'Crocodile', 'In great health.', '2024-06-02 23:36:19', NULL, NULL),
	(3, 'Benoit', 'Raccoon', 'Tummy ache, otherwise in great health.', '2024-06-02 23:36:56', NULL, NULL),
	(4, 'Milford', 'Hippopotamus', 'Tooth-ache.', '2024-06-03 11:16:41', NULL, NULL),
	(7, 'Rachel', 'Coyote', 'In good health.', '2024-06-03 11:55:49', NULL, NULL),
	(13, 'Gilbert', 'Armadillo', 'Conjunctivitis.', '2024-06-04 15:20:12', '2024-06-04 15:20:29', NULL),
	(16, 'Benson', 'Giraffe', 'In perfect condition.', '2024-06-04 19:45:57', '2024-06-04 19:46:17', NULL);

-- Dumping structure for table poc_database.task
CREATE TABLE IF NOT EXISTS `task` (
  `task_id` int unsigned NOT NULL AUTO_INCREMENT,
  `animal_id` int unsigned NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `summary` text COLLATE utf8mb4_unicode_ci,
  `expected_start_time` datetime NOT NULL,
  `expected_end_time` datetime NOT NULL,
  `actual_start_time` datetime DEFAULT NULL,
  `actual_end_time` datetime DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `fk_task_animal_id` (`animal_id`),
  CONSTRAINT `fk_task_animal_id` FOREIGN KEY (`animal_id`) REFERENCES `animal` (`animal_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table poc_database.task: ~2 rows (approximately)
INSERT INTO `task` (`task_id`, `animal_id`, `name`, `summary`, `expected_start_time`, `expected_end_time`, `actual_start_time`, `actual_end_time`, `created_at`, `updated_at`, `deleted_at`) VALUES
	(2, 16, 'Benson Check-up', 'No summary.', '2024-06-02 22:09:35', '2024-06-02 23:09:34', NULL, NULL, '2024-06-02 22:09:47', NULL, NULL),
	(4, 7, 'Rachel Diet-Check', 'No summary.', '2024-06-03 14:09:44', '2024-06-03 16:09:46', NULL, NULL, '2024-06-03 14:09:59', NULL, NULL),
	(5, 2, 'Give prescrption to Bob', 'Give prescription.', '2024-06-04 00:30:55', '2024-06-04 02:30:56', NULL, NULL, '2024-06-04 00:30:57', NULL, NULL),
	(6, 1, 'Igor Check-up', 'No summary.', '2024-06-02 22:09:32', '2024-06-02 23:09:34', NULL, NULL, '2024-06-04 16:02:19', NULL, NULL),
	(16, 4, 'Milford flu check', 'Check if Milford the Hippopotamus caught flu', '2000-05-01 01:01:01', '2000-01-01 02:01:01', NULL, NULL, '2024-06-04 18:46:29', NULL, NULL),
	(23, 7, 'default', 'default', '2000-01-01 01:01:01', '2000-01-01 02:01:01', NULL, NULL, '2024-06-04 19:52:48', NULL, NULL);

-- Dumping structure for table poc_database.veterinarian
CREATE TABLE IF NOT EXISTS `veterinarian` (
  `veterinarian_id` int unsigned NOT NULL AUTO_INCREMENT,
  `id_card_code` varchar(6) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `surname` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL DEFAULT (now()),
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`veterinarian_id`),
  UNIQUE KEY `id_card_code` (`id_card_code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table poc_database.veterinarian: ~2 rows (approximately)
INSERT INTO `veterinarian` (`veterinarian_id`, `id_card_code`, `name`, `surname`, `created_at`, `updated_at`, `deleted_at`) VALUES
	(1, 'ABC123', 'George', 'Johnson', '2024-06-02 11:26:35', NULL, NULL),
	(3, 'HGF835', 'Melissa', 'Smith', '2024-06-02 22:29:33', NULL, NULL);

-- Dumping structure for table poc_database.veterinarian_task
CREATE TABLE IF NOT EXISTS `veterinarian_task` (
  `veterinarian_task_id` int unsigned NOT NULL AUTO_INCREMENT,
  `veterinarian_id` int unsigned NOT NULL,
  `task_id` int unsigned NOT NULL,
  PRIMARY KEY (`veterinarian_task_id`),
  KEY `fk_veterinarian_task_veterinarian_id` (`veterinarian_id`),
  KEY `fk_veterinarian_task_task_id` (`task_id`),
  CONSTRAINT `fk_veterinarian_task_task_id` FOREIGN KEY (`task_id`) REFERENCES `task` (`task_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_veterinarian_task_veterinarian_id` FOREIGN KEY (`veterinarian_id`) REFERENCES `veterinarian` (`veterinarian_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table poc_database.veterinarian_task: ~2 rows (approximately)
INSERT INTO `veterinarian_task` (`veterinarian_task_id`, `veterinarian_id`, `task_id`) VALUES
	(4, 1, 2),
	(7, 3, 4),
	(8, 1, 5);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
